package be.hanoulle.configChecker;

public class Runner {

    // Usage: assuming you've compiled your java classes to a target directory in the root of the project:
    // 1. Navigate inside the target dir
    // 2. Create a jar file: jar cfvm ../configChecker.jar ../src/manifest.mf be/hanoulle/configChecker/DHCPConfig.class be/hanoulle/configChecker/Runner.class
    // 3. Run the jar as follows (from the root of the project): java -jar configChecker.jar locationOfSomeConfigFile

    public static void main(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            DHCPConfig dhcpConfig = new DHCPConfig();
            // Do whatever checks you want to do here
            int openParentheses = dhcpConfig.CountOpenParentheses(fileName);
            System.out.println("Number of open parantheses: " + openParentheses);
            // You might even add a push to github somehow if you feel like it.
        } else {
            System.out.println("Error: no file name given. Please provide the filename as first argument");
        }
    }
}