package com.team.soc00.qna.controller;

public class QnaPage {

	private int num;
	private int count;
	private int postNum = 10;
	private int pageNum;
	private int displayPost;
	private int pageNum_count = 10;
	private int endPageNum;
	private int startPageNum;
	
	private boolean prev;
	private boolean next;
	
	public void setNum(int num) {
		 this.num = num;
		}

		public void setCount(int count) {
		 this.count = count;
		 
		 dataCalc();
		}

		public int getCount() {
		 return count;
		}

		public int getPostNum() {
		 return postNum;
		}

		public int getPageNum() {
		 return pageNum;
		}

		public int getDisplayPost() {
		 return displayPost;
		}

		public int getpageNum_count() {
		 return pageNum_count;
		}

		public int getEndPageNum() {
		 return endPageNum;
		}

		public int getStartPageNum() {
		 return startPageNum;
		}

		public boolean getPrev() {
		 return prev;
		} 

		public boolean getNext() {
		 return next;
		}
		
	private void dataCalc() {
		
		endPageNum = (int)(Math.ceil((double)num / (double)pageNum_count) * pageNum_count);
		
		startPageNum = endPageNum - (pageNum_count - 1);
		
		int endPageNum_result = (int)(Math.ceil((double)count / (double)pageNum_count));
		
		if(endPageNum > endPageNum_result){
			endPageNum = endPageNum_result;
		}
		
		prev = startPageNum == 1 ? false:true;
		next = endPageNum * pageNum_count >= count ? false:true;
		
		displayPost = (num - 1) * postNum;
	}
	

}
