package TestNGDemo;

public class test {
    public static void main(String[] args) {
        String yourName="你的名字";
        String hanpi="憨批";
        assert yourName.equals(hanpi):"false";
        System.out.println("恭喜！你不是憨批！");
        assert yourName==hanpi:"false";
        System.out.println("不！你的内存地址与憨批的内存地址相同！你是披了马甲的憨批！");
    }
}











//assert yourName.equals("你的名字"):"no";