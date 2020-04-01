package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Modify implements View {

	@Override
	public void display() {
		System.out.println(modifyTitle);
		if(data.dtoArr.length==0){
			return;
		}
		System.out.print("수정할 idx 입력: ");
		int idx = scan.nextInt();
		boolean flag = false;
		for(int i =0;i<data.dtoArr.length;i++){
			if(data.dtoArr[i].getIdx()==idx){
				flag=true;
				break;
			}
		}
		if(!flag){
			System.out.println("선택한 idx의 정보가 없습니다!");
			data.dto=new Dto(0, null, null);
			return;
		}
		System.out.print("새 이름 입력: ");
		String name = scan.next();
		System.out.print("새 전화 번호: ");
		String phone = scan.next();
		data.dto=new Dto(idx, name, phone);
	}

}
