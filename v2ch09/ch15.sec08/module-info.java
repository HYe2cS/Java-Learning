import com.horstmann.greetsvc.GreeterService;

@SuppressWarnings("module")
module ch15.sec08 {
    requires com.horstmann.greetsvc;
    uses GreeterService;
}
