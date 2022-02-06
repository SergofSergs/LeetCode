package src;

public class AddTwoNumbers 
{
	public static class ListNode
	{
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	/*You are given two non-empty linked lists representing two non-negative integers. 
	The digits are stored in reverse order, and each of their nodes contains a single digit. 
	Add the two numbers and return the sum as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
	
	private static short nSun(ListNode list, int n1, int n2, short factor)
	{
		list.val = n1 + n2 + factor;
		factor = 0;
		if (list.val >= 10)
		{
			list.val %= 10;
			factor = 1;
		}
		return factor;
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode list = new ListNode();
		ListNode start = list;
		short factor = 0;

		while(l1 != null || l2 != null)
		{
			if (l1 == null)
			{
				factor = nSun(list, 0, l2.val, factor);
				l2 = l2.next;
			}
			else if (l2 == null)
			{
				factor = nSun(list, l1.val, 0, factor);
				l1 = l1.next;
			}
			else if (l1 != null && l2 != null)
			{
				factor = nSun(list, l1.val, l2.val, factor);
				l1 = l1.next;
				l2 = l2.next;
			}
			if (l1 != null || l2 != null)
			{
				list.next = new ListNode();
				list = list.next;
			}
		}
		if (factor == 1)
		{
			list.next = new ListNode();
			list = list.next;
			list.val = 1;
		}
		return (start);
	}

	private static void fillList(ListNode l, long n)
	{
		while (n != 0)
		{
			l.val = (int)(n % 10);
			if (n / 10 != 0)
				l.next = new ListNode();
			l = l.next;
			n /= 10;
		}
	}
/*
	private static void fillListChar(ListNode l, char[] n)
	{
		int i;

		i = 0;
		while (i < 31)
		{
			l.val = n[i] - (int)'0';
			l.next = new ListNode();
			l = l.next;
			i++;
		}
	}
*/
	public static void main(String[] args)
	{
		//char[] n1 = {'1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'};
		long n1 = 342;
		long n2 = 465;
		ListNode l1;
		ListNode l2;
		
		l1 = new ListNode();
		l2 = new ListNode();
		//fillListChar(l1, n1);
		fillList(l1, n1);
		fillList(l2, n2);
		ListNode l3 = addTwoNumbers(l1, l2);
		for(;l3 != null; l3 = l3.next)
			System.out.println(l3.val);
	}
}
