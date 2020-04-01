package org.comstudy21.model;

public class Dao {
	public static final int MAX = 100;
	private Dto[] dtoArr = new Dto[MAX];
	private int top = 0; // 현재 입력데이터 갯수
	private int seq = 1; // 데이터가 추가 될 때마다 계속 증가한다.

	{
		dtoArr[top++] = new Dto(seq++, "KIM", "010-1111-1111");
		dtoArr[top++] = new Dto(seq++, "LEE", "010-2222-2222");
		dtoArr[top++] = new Dto(seq++, "KIM", "010-3333-3333");
		dtoArr[top++] = new Dto(seq++, "PARK", "010-4444-4444");
		dtoArr[top++] = new Dto(seq++, "LEE", "010-5555-5555");
		dtoArr[top++] = new Dto(seq++, "KANG", "010-6666-6666");
	}

	// 싱글톤
	private Dao() {
	}

	private static Dao instance; // 참조변수는 null로 초기화 됨

	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}

	public void insert(Dto dto) {
		dto.setIdx(seq++);
		dtoArr[top++] = dto;
	}

	public Dto[] selectAll() {// 외부 접근을 막기 위해 dtoArr을 바로 리턴하기보다 arr을 새로 만들어 리턴
		Dto[] arr = new Dto[top];
		for (int i = 0; i < top; i++) {
			arr[i] = new Dto();
			arr[i].setIdx(dtoArr[i].getIdx());
			arr[i].setName(dtoArr[i].getName());
			arr[i].setPhone(dtoArr[i].getPhone());
		}
		return arr;
	}

	public Dto[] select(Dto dto) {
		Dto[] newArr = new Dto[top];
		int cnt = 0;
		for (int i = 0; i < top; i++) {
			if (dtoArr[i].getName().toUpperCase()
					.equals(dto.getName().toUpperCase())) {
				newArr[cnt] = new Dto();// clone 으로 짜보기
				newArr[cnt].setIdx(dtoArr[i].getIdx());
				newArr[cnt].setName(dtoArr[i].getName());
				newArr[cnt].setPhone(dtoArr[i].getPhone());
				cnt++;
			}
		}
		Dto[] arr = new Dto[cnt];
		for (int i = 0; i < cnt; i++) {
			arr[i] = newArr[i];
		}
		return arr;
	}

	public Dto selectOne(Dto dto) {
		return null;
	}

	public void update(Dto dto) {
		boolean flag = false;
		for (int i = 0; i < top; i++) {
			if (dto.getIdx() == dtoArr[i].getIdx()) {
				dtoArr[i] = dto;
				flag = true;
				return;
			}
		}
		if (flag) {
			System.out.println("-------수정 성공입니다-------");
		} else {
			System.out.println("-------수정 실패입니다-------");
		}
	}

	public void delete(Dto dto) {
		boolean flag = false;
		for (int i = 0; i < top; i++) {
			if (dto.getIdx() == dtoArr[i].getIdx()) {
				for (int j = i; j < top - 1; j++) {
					dtoArr[j] = dtoArr[j + 1];
				}
				dtoArr[top - 1] = null;
				top--;
				flag = true;
				return;
			}
		}
		if (flag) {
			System.out.println("삭제 완료!");
		} else {
			System.out.println("삭제 실패!");
		}
	}

}
