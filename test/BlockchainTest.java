/** 简单测试类，不依赖 JUnit 等第三方工具。 */
public class BlockchainTest {
    public static void main(String[] args) {
        testNewChainIsValid();
        testAddBlock();
        testChangedDataCanBeDetected();
        testEmptyDataIsRejected();
        System.out.println("全部 4 项测试通过。");
    }

    private static void testNewChainIsValid() {
        Blockchain chain = new Blockchain();
        check(chain.isValid(), "新建区块链应当有效");
    }

    private static void testAddBlock() {
        Blockchain chain = new Blockchain();
        chain.addBlock("第一条学习记录");
        check(chain.getBlocks().size() == 2, "添加后应当有两个区块");
        check(chain.isValid(), "正常添加后区块链应当有效");
    }

    private static void testChangedDataCanBeDetected() {
        Blockchain chain = new Blockchain();
        chain.addBlock("原始数据");
        chain.getBlocks().get(1).setData("被修改的数据");
        check(!chain.isValid(), "数据被修改后应当验证失败");
    }

    private static void testEmptyDataIsRejected() {
        Blockchain chain = new Blockchain();
        boolean rejected = false;
        try {
            chain.addBlock("   ");
        } catch (IllegalArgumentException e) {
            rejected = true;
        }
        check(rejected, "空数据应当被拒绝");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
