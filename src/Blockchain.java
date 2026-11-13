import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 由多个区块连接而成的简单哈希链。 */
public class Blockchain {
    private final List<Block> blocks = new ArrayList<>();

    public Blockchain() {
        blocks.add(new Block(0, "创世区块", "0"));
    }

    /** 添加新区块，并把上一个区块的哈希保存到新区块中。 */
    public void addBlock(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("区块数据不能为空");
        }
        Block last = blocks.get(blocks.size() - 1);
        Block next = new Block(blocks.size(), data.trim(), last.getHash());
        blocks.add(next);
    }

    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    /** 检查每个区块的哈希和前序连接是否正确。 */
    public boolean isValid() {
        for (int i = 0; i < blocks.size(); i++) {
            Block current = blocks.get(i);

            if (current.getIndex() != i) {
                return false;
            }
            if (!current.getHash().equals(current.calculateHash())) {
                return false;
            }
            if (i == 0) {
                if (!"0".equals(current.getPreviousHash())) {
                    return false;
                }
            } else {
                Block previous = blocks.get(i - 1);
                if (!previous.getHash().equals(current.getPreviousHash())) {
                    return false;
                }
            }
        }
        return true;
    }
}
