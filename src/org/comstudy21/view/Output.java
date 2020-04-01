package org.comstudy21.view;

public class Output implements View {

	@Override
	public void display() {
		
		if(data.dtoArr==null){
			System.out.println("출력할 내용이 없습니다!");
			return;
		}
		
		System.out.println(outputTitle);
		for(int i=0;i<data.dtoArr.length;i++){
			System.out.println(data.dtoArr[i]);
		}
	}

}
