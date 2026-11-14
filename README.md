# 区块链哈希链演示工具（Java）

这是一个面向初学者的Java区块链教学项目，重点展示区块数据与完整性验证。

## 项目目标

- 创建创世区块。
- 添加新的区块，并记录上一个区块的哈希。
- 查看区块编号、数据、前序哈希和当前哈希。
- 重新计算哈希，检查区块内容和连接关系是否正常。
- 通过简单测试演示数据被修改后验证失败。

> 本项目是教学演示，不是可用于真实资产或生产环境的完整区块链。它没有实现点对点网络、共识机制、钱包或数字签名。

## 环境要求

- JDK 8 或更高版本。
- 不需要安装第三方 Java 库。

## 运行程序

在项目根目录打开终端。

### Windows（命令提示符或 PowerShell）

```bash
javac -encoding UTF-8 -d out src\*.java
java -cp out Main
```

### macOS / Linux

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

程序菜单中输入 `1` 添加区块、输入 `2` 查看区块、输入 `3` 验证哈希链、输入 `0` 退出。

## 运行测试

先完成上面的编译，再执行：

### Windows

```bash
javac -encoding UTF-8 -cp out -d out test\BlockchainTest.java
java -cp out BlockchainTest
```

### macOS / Linux

```bash
javac -encoding UTF-8 -cp out -d out test/BlockchainTest.java
java -cp out BlockchainTest
```

看到“全部 4 项测试通过。”表示基础测试通过。

## 项目结构

```text
blockchain-hash-demo-55/
├── src/
│   ├── Block.java
│   ├── Blockchain.java
│   └── Main.java
├── test/
│   └── BlockchainTest.java
├── docs/
│   ├── PROJECT_ANALYSIS.md
│   └── DISCUSSION.md
├── README.md
├── LICENSE
├── CONTRIBUTING.md
└── .gitignore
```

## 开源许可证

本项目采用 MIT License。详细内容见根目录 `LICENSE` 文件。

## 参与贡献

欢迎通过 Issue 提出问题或建议，也欢迎 Fork 项目、创建分支并提交 Pull Request。提交前请先运行基础测试。具体约定见 `CONTRIBUTING.md`。

## 学习提示

哈希用于把区块内容转换成固定长度的摘要；前序哈希用于把新区块与上一个区块连接起来。修改已保存区块的数据后，重新计算得到的哈希会与原哈希不一致，因此程序能够发现这种改动。

## 分支验证练习

本分支用于演示区块链数据完整性验证流程。
