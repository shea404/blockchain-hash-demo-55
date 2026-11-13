import java.util.List;
import java.util.Scanner;

/** 程序入口：通过简单菜单演示创建、查看和验证哈希链。 */
public class Main {
    public static void main(String[] args) {
        Blockchain chain = new Blockchain();
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      区块链哈希链演示工具");
        System.out.println("================================");

        boolean running = true;
        while (running) {
            System.out.println("\n1. 添加区块");
            System.out.println("2. 查看全部区块");
            System.out.println("3. 验证哈希链");
            System.out.println("0. 退出程序");
            System.out.print("请输入选项：");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("请输入要保存的数据：");
                    String data = scanner.nextLine();
                    try {
                        chain.addBlock(data);
                        System.out.println("区块添加成功。");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    List<Block> blocks = chain.getBlocks();
                    for (Block block : blocks) {
                        System.out.println("------------------------------");
                        System.out.println(block);
                    }
                    break;
                case "3":
                    if (chain.isValid()) {
                        System.out.println("验证通过：区块数据和连接关系正常。");
                    } else {
                        System.out.println("验证失败：检测到数据或连接异常。");
                    }
                    break;
                case "0":
                    running = false;
                    System.out.println("程序已退出。");
                    break;
                default:
                    System.out.println("选项无效，请重新输入。");
            }
        }
        scanner.close();
    }
}
