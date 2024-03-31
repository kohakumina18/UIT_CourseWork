int ngay, thang, nam, s =0;
string Thu[] = { "Thu nam", "Thu sau", "Thu bay", "Chu Nhat", "Thu Hai", "Thu ba", "Thu Tu"};
//Nhap ngay thang nam
s= ngay;
for (i=1; i< thang; i++)
{
	switch (i):
	{
		case 1 : case 3 : case 5: case 7 : case 8 : case 10 : case 12 : s=s+31; break
		case 2 :  if (nam nhuan) //implement code tinh nam nhuan
					s=s+29;
				else 
					s=s+28;
				break
		case 4 : case 6: case 9 : case 11:
		s=s+30; 
		break;
	}
}
for(i=1970; i< nam; i++){
		if (nam i la nhuan)
				s=s+366;
		else s=s+365;
}
s=s-1;
System.out.println( thu[s%7] );
