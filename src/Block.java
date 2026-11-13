import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 一个简单的区块：保存数据、前一个区块的哈希和自己的哈希。 */
public class Block {
    private final int index;
    private final long time;
    private String data;
    private final String previousHash;
    private final String hash;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.time = System.currentTimeMillis();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public int getIndex() {
        return index;
    }

    public long getTime() {
        return time;
    }

    public String getData() {
        return data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    /** 根据区块当前内容重新计算 SHA-256 哈希。 */
    public String calculateHash() {
        String text = index + "|" + time + "|" + data + "|" + previousHash;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                result.append(String.format("%02x", b & 0xff));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("当前 Java 环境不支持 SHA-256", e);
        }
    }

    /** 仅用于课堂演示：修改数据后，原哈希不会自动改变，验证时应当失败。 */
    public void setData(String data) {
        this.data = data;
    }

    public String getTimeText() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }

    @Override
    public String toString() {
        return "区块编号：" + index + "\n"
                + "创建时间：" + getTimeText() + "\n"
                + "数据内容：" + data + "\n"
                + "前序哈希：" + previousHash + "\n"
                + "当前哈希：" + hash + "\n";
    }
}
