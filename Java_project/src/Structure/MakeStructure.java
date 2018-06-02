package Structure;

//자료구조 트리 만듬
public class MakeStructure{
	int height;
	public String name;	
	String list[];
	String fixList[];
	public MakeStructure next[] = new MakeStructure[4];		//하나의 노드에 붙는 다른 노드들의 최대 개수
	public MakeStructure(String[] list) {
		this.list = list;									//\n을 기준으로 split된 문자열을 받는다.
		height = tabcount(list[0]);							//현재 자료의 높이(=\t개수) 설정
		name = list[0].trim();
		if (list.length > 1) {								//fixList는 list의 배열들을 한 칸씩 앞으로 당긴 것(ex) fixList[0] == List[1];
			fixList = new String[list.length-1];			//list.length가 1이 되면 fixList의 길이가 0이 되므로 이를 방지해준다.
			for(int i = 0; i < list.length-1; i++) {
				fixList[i] = list[i + 1];
			}
			MoveNext();
		}
	}
	//다음 노드가 있다면 다음 노드를 연결시킨다.
	public void MoveNext() {
		if (fixList.length > 0) {
			int num = fixList.length;
			int nextHeight;
			
			for(int i = 0, j = 0; i < num; i++) {
				
				if(fixList == null)		//fixList가 null일 경우는 기존의 문자열 List가 끝에 다다라 38번째 코드처럼  null을 리턴하는 경우밖에 없다. 즉  끝 설정
					break;
				nextHeight = tabcount(fixList[0]);	
			//다음 노드의 height가 현재 노드의 height보다 1만큼 높을 경우에만 next로 다음 노드 연결. 그렇지 않을 경우 for문 break.
				if(nextHeight == height + 1) {
					next[j] = new MakeStructure(fixList);
					if (next[j].fixList == null) {		//List 문자열의 최종에 다다랐을 경우 fixList를 따로 배정하지 않으므로  fixList는 null이 된다.
						fixList = null;
					}
					else {								//List 문자열의 최종이 아닐 경우 현재 노드의 next에서 쓰던 fixList를 받아온다.
						fixList = new String[next[j].ReturnFixList().length];
						fixList = next[j].ReturnFixList();
					}
					j++;													//나중에 next[4]넘어가는 순간 오류메시지 출력 기능 넣어도 될 듯
				}
				else if (nextHeight <= height)		//다음 노드의 height가 현재 노드와 같거나 현재 노드보다 낮을 경우 for문 break
					break;
			}
		}
	}
	
	//현재 List를 리턴한다.
	public String[] ReturnList() {
		return list;
	}
	//현재 FixList를 리턴한다.
	public String[] ReturnFixList() {
		return fixList;
	}
	//\t의 개수를 리턴한다.
	public int tabcount(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\t')
				count++;
		}
		return count;
	}
}
