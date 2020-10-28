import java.util.*;
public class TestHarness
{
    public static void main(String[] args)
    {
        OptimizedLog<String> log = new OptimizedLog<>();
        log.add("Hello world!");
        log.add("Another entry...");
        log.add("SPAM...");
        log.add("SPAM...");
        log.add("SPAM...");
        System.out.println(log);
    }
}