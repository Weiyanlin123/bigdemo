package com.city.list;

class WhileAndDoWhile
{
    public static void main(String[] args)
	{
		int [] aaa=new int[]{1,2,3,4};
		System.out.println(aaa);

		//定义变量
		int x=13;
		while(x<=10){
			System.out.println("x="+x);
			x++;
		}

		System.out.println("--------------------");
		int y=9;
		do{
			System.out.println("y="+y);
			y++;
		}while(y<=10);
		System.out.println("haha");
	}



}