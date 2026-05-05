class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0, tenCnt = 0, twentyCnt = 0;
        for(int bill : bills){
            if(bill == 5){
                fiveCnt++;
            }else if(bill == 10){
                if(fiveCnt == 0) return false;
                fiveCnt--;
                tenCnt++;
            }else{
                if(tenCnt > 0 && fiveCnt > 0){
                    tenCnt--;
                    fiveCnt--;
                }else if(fiveCnt >= 3){
                    fiveCnt -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}