import com.horstmann.greetsvc.GreeterService;

@SuppressWarnings("module")
module v2ch09.useservice
{
    requires com.horstmann.greetsvc;
    uses GreeterService;
}
