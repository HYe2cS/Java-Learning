package book;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;

/**
 * A banner that prints a text string on multiple pages.
 */
public class Banner implements Printable {
    private final String message;
    private double scale;
    
    /**
     * Constructs a banner.
     *
     * @param m the message string
     */
    public Banner(String m) {
        message = m;
    }
    
    /**
     * Gets the page count of this section.
     *
     * @param g2 the graphics context
     * @param pf the page format
     * @return the number of pages needed
     */
    public int getPageCount(Graphics2D g2, PageFormat pf) {
        if ("".equals(message)) {
            return 0;
        }
        FontRenderContext context = g2.getFontRenderContext();
        var f = new Font("Serif", Font.PLAIN, 72);
        Rectangle2D bounds = f.getStringBounds(message, context);
        scale = pf.getImageableHeight() / bounds.getHeight();
        double width = scale * bounds.getWidth();
        int pages = (int) Math.ceil(width / pf.getImageableWidth());
        return pages;
    }
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        var g2 = (Graphics2D) g;
        if (page > getPageCount(g2, pf)) {
            return Printable.NO_SUCH_PAGE;
        }
        g2.translate(pf.getImageableX(), pf.getImageableY());
        
        drawPage(g2, pf, page);
        return Printable.PAGE_EXISTS;
    }
    
    public void drawPage(Graphics2D g2, PageFormat pf, int page) {
        if ("".equals(message)) {
            return;
        }
        page--; // account for cover page
        
        drawCropMarks(g2, pf);
        g2.clip(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf.getImageableHeight()));
        g2.translate(-page * pf.getImageableWidth(), 0);
        g2.scale(scale, scale);
        FontRenderContext context = g2.getFontRenderContext();
        var f = new Font("Serif", Font.PLAIN, 72);
        var layout = new TextLayout(message, f, context);
        AffineTransform transform = AffineTransform.getTranslateInstance(0, layout.getAscent());
        Shape outline = layout.getOutline(transform);
        g2.draw(outline);
    }
    
    /**
     * Draws 1/2" crop marks in the corners of the page.
     *
     * @param g2 the graphics context
     * @param pf the page format
     */
    public void drawCropMarks(Graphics2D g2, PageFormat pf) {
        final double C = 36; // crop mark length = 1/2 inch
        double w = pf.getImageableWidth();
        double h = pf.getImageableHeight();
        g2.draw(new Line2D.Double(0, 0, 0, C));
        g2.draw(new Line2D.Double(0, 0, C, 0));
        g2.draw(new Line2D.Double(w, 0, w, C));
        g2.draw(new Line2D.Double(w, 0, w - C, 0));
        g2.draw(new Line2D.Double(0, h, 0, h - C));
        g2.draw(new Line2D.Double(0, h, C, h));
        g2.draw(new Line2D.Double(w, h, w, h - C));
        g2.draw(new Line2D.Double(w, h, w - C, h));
    }
}

/**
 * This class prints a cover page with a title.
 */
class CoverPage implements Printable {
    private final String title;
    
    /**
     * Constructs a cover page.
     *
     * @param t the title
     */
    public CoverPage(String t) {
        title = t;
    }
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        var g2 = (Graphics2D) g;
        g2.setPaint(Color.black);
        g2.translate(pf.getImageableX(), pf.getImageableY());
        FontRenderContext context = g2.getFontRenderContext();
        Font f = g2.getFont();
        var layout = new TextLayout(title, f, context);
        float ascent = layout.getAscent();
        g2.drawString(title, 0, ascent);
        return Printable.PAGE_EXISTS;
    }
}
