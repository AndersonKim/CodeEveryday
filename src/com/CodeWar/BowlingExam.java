package com.CodeWar;

public class BowlingExam {
    static String test1="";//300:X|X|X|X|X|X|X|X|X|X||XX
    static String test4 = "X|X|X|X|X|X|X|X|X|X||XX";//167
    String test2="";//90:9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||
    String test3="";//150:5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5

    public static void main(String[] args) {

        /*获取分割标记|POS*/
        int[] posOfSub=getSubPos();





        int index=0;
        //计算每块的内部分数，每块的内部分数由第一次与第二次的两部分的分构成
        //将分数的指示字符串提取出来
        //第10，11相邻的|没有内部字符串
        //两次得分
        int[] blockScore1={0,0,0,0,0,0,0,0,0,0,0};
        int[] blockScore2={0,0,0,0,0,0,0,0,0,0,0};
        //内部字符串
        String[] blockStr={"","","","","","","","","","",""};
        index=0;
        for(int i=0;i<posOfSub.length;i++){
            //字符串分块
            String blockTemp="";
            //特殊处理第一个和最后一个块内容
            if (i==0){
                blockTemp=test4.substring(0,posOfSub[i]);
                blockStr[index++]=blockTemp;
            }
            else if (i==10){
                blockTemp=test4.substring(posOfSub[i]+1,test4.length());
                blockStr[index++]=blockTemp;
            }
            else{
                blockTemp=test4.substring(posOfSub[i-1]+1,posOfSub[i]);
                blockStr[index++]=blockTemp;
            }
            //每块内容的得分
            //X-/
            if (blockTemp.contains("X")){
                if (blockTemp.length()==2){
                    blockScore1[i]=10;
                    blockScore2[i]=10;
                }else {
                    blockScore1[i]=10;
                    blockScore2[i]=0;
                }

            }else if (blockTemp.contains("/")){
                //根据符号的位置计算得分
                int posOfDivide=blockTemp.substring(0,1).equals("/")?0:1;
                if (posOfDivide==0){
                    blockScore2[i]=Integer.parseInt(blockTemp.substring(1,2));
                    blockScore1[i]=10-blockScore2[i];
                }else {
                    blockScore1[i]=Integer.parseInt(blockTemp.substring(0,1));
                    blockScore2[i]=10-blockScore1[i];
                }

            }else if (blockTemp.contains("-")){
                int posOfMini=blockTemp.substring(0,1).equals("-")?0:1;
                if (posOfMini==0){
                    blockScore2[i]=Integer.parseInt(blockTemp.substring(1,2));
                    blockScore1[i]=0;
                }else {
                    blockScore1[i]=Integer.parseInt(blockTemp.substring(0,1));
                    blockScore2[i]=0;
                }
            }else{
                if (blockTemp.length()==2){
                    blockScore1[i]=Integer.parseInt(blockTemp.substring(0,1));
                    blockScore2[i]=Integer.parseInt(blockTemp.substring(1,2));
                }else if(blockTemp.length()==1){
                    blockScore1[i]=Integer.parseInt(blockTemp.substring(0,1));
                    blockScore2[i]=0;
                }else{
                    blockScore1[i]=0;
                    blockScore2[i]=0;
                }
            }
        }

        //应用计分法则计算
        int sum=0;
        for (int i = 0; i <10 ; i++) {
            //存在X
            if (blockScore1[i]==10){
                if (blockScore1[i+1]==10){
                    //连X处理
                    if (blockScore2[i+1 ]==10){
                        sum+=10+blockScore1[i+1]+blockScore2[i+1];
                    }else{
                        sum+=10+blockScore1[i+1]+blockScore1[i+2];
                    }
                }else {
                    sum+=10+blockScore1[i+1]+blockScore2[i+1];
                }

            }
            //存在/
            else if (blockScore1[i]+blockScore2[i]==10){
                if (blockScore1[i+1]==10){
                    sum+=10+blockScore1[i+1];
                }else {
                    sum+=10+blockScore1[i+1];
                }
            }else{
                sum+=blockScore1[i]+blockScore2[i];
            }
        }
        System.out.println(sum);
    }

    private static int[] getSubPos() {
        //将字符串切割成11块，10块分数和一块附加分
        int[] posOfSub={0,0,0,0,0,0,0,0,0,0,0};
        int index=0;
        for (int i = 0; i <test4.length() ; i++) {
            if (test4.charAt(i)=='|'){
                posOfSub[index++]=i;
            }
        }
        return posOfSub;

    }
}
