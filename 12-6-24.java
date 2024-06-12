public static int countNumberswith4(int n) {
        // code here
        int count = 0;
        while(n>3){
            String str = Integer.toString(n--);
            if(str.indexOf("4") != -1) count++;
        }
        return count;
    }

