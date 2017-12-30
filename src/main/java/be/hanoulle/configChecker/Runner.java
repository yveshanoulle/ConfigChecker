package be.hanoulle.configChecker;

public class Runner {

        public static void main(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            DHCPConfig dhcpConfig = new DHCPConfig();

            System.out.println(dhcpConfig.VerifyFile(fileName));

        } else {
            System.out.println("Error: no file name given. Please provide the filename as first argument");
        }
    }

}