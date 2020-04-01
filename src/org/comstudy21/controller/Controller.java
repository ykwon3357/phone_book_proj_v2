package org.comstudy21.controller;

import org.comstudy21.resource.Data;
import org.comstudy21.view.Search;

import static org.comstudy21.resource.R.*;

import org.comstudy21.model.Dto;

public class Controller {
	public static void search(){
		viewArr[3].display();//검색 입력 기능
		data.dtoArr = dao.select(data.dto);
		((Search)viewArr[3]).display(data.dtoArr);//출력 기능
	}
	public static void service() {
		try {
			viewArr[data.no].display();

			switch (data.no) {
			case 1:
				viewArr[data.no].display();
				// 입력받은 data.dto 데이터를 Dao로 넘긴다.
				dao.insert(data.dto);
				break;
			case 2:
				// Dao에서 데이터를 가져온 후에 뷰로 이동
				data.dtoArr = dao.selectAll();
				viewArr[data.no].display();
				break;
			case 3:
				search();
				break;
			case 4:
				search();
				viewArr[data.no].display();
				if(data.dto.getIdx()!=0){
				dao.update(data.dto);
				}
				break;
			case 5:
				search();
				viewArr[data.no].display();
				if(data.dto.getIdx()!=0){
				dao.delete(data.dto);
				}
				break;
			case 6:
				System.out.println("-----프로그램 종료-----");
				System.exit(0);
				break;
			default:
				System.out.println("해당 사항 없습니다!");

			}
		} catch (NullPointerException e) {
			System.out.println("주의: 메뉴가 준비 되지 않았습니다.");
		} catch (Exception e) {
			System.out.println("주의: 해당 사항 없습니다.");
		}
		data.no = 0;
		service();
	}
}
