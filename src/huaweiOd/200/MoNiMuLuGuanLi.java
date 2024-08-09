import java.util.HashMap;
import java.util.Scanner;
//模拟目录管理
public class MoNiMuLuGuanLi {
    static class TreeNode {
        String curDicName;
        TreeNode father;
        HashMap<String, TreeNode> children;

        public TreeNode(String curDicName, TreeNode father) {
            this.curDicName = curDicName;
            this.father = father;
            this.children = new HashMap<>();
        }
    }

    static class Tree {
        TreeNode root;
        TreeNode cur;

        public Tree() {
            // root是根目录，根目录 / 作为初始目录
            this.root = new TreeNode("/", null);
            // cur用于指向当前正在操作的目录
            this.cur = root;
        }

        public void mkdir(String childDicName) {
            // mkdir 目录名称，如 mkdir abc 为在当前目录创建abc目录，如果已存在同名目录则不执行任何操作
            this.cur.children.putIfAbsent(
                    childDicName, new TreeNode(childDicName + "/", this.cur)); // 目录符号为 /
        }

        public void cd(String dicName) {
            if (dicName.equals("..")) {
                // cd .. 为返回上级目录，如果目录不存在则不执行任何操作
                if (this.cur.father != null) {
                    // cur 变更指向上级目录
                    this.cur = this.cur.father;
                }
            } else {
                // cd 目录名称，如 cd abc 为进入abc目录，如果目录不存在则不执行任何操作
                if (this.cur.children.containsKey(dicName)) {
                    // cur 变更指向下级目录
                    this.cur = this.cur.children.get(dicName);
                }
            }
        }

        public String pwd() {
            // 输出当前路径字符串
            StringBuilder sb = new StringBuilder();

            // 倒序路径，即不停向上找父目录
            TreeNode cur = this.cur;
            while (cur != null) {
                // 头插目录名，保证路径中目录层级正确
                sb.insert(0, cur.curDicName);
                cur = cur.father;
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 初始化目录结构
        Tree tree = new Tree();

        // 记录最后一条命令的输出
        String lastCommandOutPut = "/";

        outer:
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // 本地测试解开此行
            //      if (line.equals("")) break;

            String[] tmp = line.split(" ");

            String cmd_key = tmp[0];

            if (cmd_key.equals("pwd")) {
                // pwd 命令不需要参数
                if (tmp.length != 1) continue;
                lastCommandOutPut = tree.pwd();
            } else if (cmd_key.equals("mkdir") || cmd_key.equals("cd")) {
                // 约束：mkdir 和 cd 命令的参数仅支持单个目录，如：mkdir abc 和 cd abc
                if (tmp.length != 2) continue;

                // 目录名
                String cmd_val = tmp[1];

                if (!(cmd_key.equals("cd") && cmd_val.equals(".."))) {
                    // 目录名约束校验
                    // 约束：目录名称仅支持小写字母
                    // 约束：不支持嵌套路径和绝对路径，如 mkdir abc/efg，cd abc/efg，mkdir /abc/efg，cd /abc/efg 是不支持的。
                    // 关于嵌套路径和绝对路径，我简单理解就是cmd_val含有'/'字符，可以被小写字母判断涵盖住
                    for (int i = 0; i < cmd_val.length(); i++) {
                        char c = cmd_val.charAt(i);
                        if (c < 'a' || c > 'z') continue outer;
                    }
                }

                if (cmd_key.equals("mkdir")) {
                    tree.mkdir(cmd_val);

                    // 题目进要求输出最后一个命令的运行结果，因此，对于无输出的命令，我认为需要覆盖掉前面的命令的输出结果
                    lastCommandOutPut = "/";
                } else {
                    tree.cd(cmd_val);
                    // 题目进要求输出最后一个命令的运行结果，因此，对于无输出的命令，我认为需要覆盖掉前面的命令的输出结果
                    lastCommandOutPut = "/";
                }
            }
        }

        System.out.println(lastCommandOutPut);
    }
}