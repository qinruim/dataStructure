//package practice.realQuestions.zhaoyinwangluo;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Package： practice.realQuestions.zhaoyinwangluo
// * @Title: Compute
// * @Author： qrpop
// * @Date： 2023-09-04 16:49
// * @description:
// */
//public class Compute {
//    static Map<Operator,IComputer> computers;
//    static {
//        computers = new HashMap<Operator,IComputer>() {{
//            put(Operator.ADD,new IComputer(){
//                @Override
//                public int compute(int a, int b) {
//                    return a + b;
//                }
//            });
//            put(Operator.SUB,(new IComputer(){
//                @Override
//                public int compute(int a, int b) {
//                    return a - b;
//                }
//            }));
//            put(Operator.MULTI,(new IComputer(){
//                @Override
//                public int compute(int a, int b) {
//                    return a * b;
//                }
//            }));
//            new IComputer(){
//                @Override
//                public int compute(int a, int b) {
//                    return a / b;
//                }
//            };
//        }};
//    }
//
//    public static void main(String[] args) {
//        BigDecimal a = BigDecimal.valueOf(1);
//        BigDecimal b = BigDecimal.valueOf(2);
//        a.add(b);
//
//    }
//
//
//    enum Operator {
//        ADD,SUB,MULTI,DIVIDE;
//    }
//    enum IComputer{
//        ADD{
//            @Override
//            public int compute(int a, int b) {
//                return a + b;
//            }
//        },
//        SUB{
//            @Override
//            public int compute(int a, int b) {
//                return a - b;
//            }
//        },
//        MULTI{
//            @Override
//            public int compute(int a, int b) {
//                return a * b;
//            }
//        },
//        DIVIDE{
//            @Override
//            public int compute(int a, int b) {
//                return a / b;
//            }
//        };
//        public abstract int compute(int a, int b);
//    }
//
//
//}
