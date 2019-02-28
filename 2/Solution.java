import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHeadPre = new ListNode(0); 
        ListNode nowNode = resultHeadPre;
        ListNode leftNode = null;
        int carry = 0;
        int nowNum = 0; 

        while(true){

            if(l1 == null){
                leftNode = l2;
                break;
            }

            if(l2 == null){
                leftNode = l1;
                break;
            }

            nowNum = l1.val + l2.val + carry;
            carry = nowNum / 10;
            nowNum = nowNum % 10;

            nowNode.next = new ListNode(nowNum);
            nowNode = nowNode.next;

            l1 = l1.next;
            l2 = l2.next; 
        }

        if(leftNode == null && carry == 0){
            
        }else if(carry == 0){
            nowNode.next = leftNode;
        }else if(leftNode == null){
            nowNode.next = new ListNode(1);
        }else{
            while(true){
                nowNum = leftNode.val + carry;
                carry = nowNum / 10;
                nowNum = nowNum % 10;
                nowNode.next = new ListNode(nowNum);
                nowNode = nowNode.next;
                leftNode = leftNode.next;
                if(carry == 1){
                    if(leftNode == null){
                        nowNode.next = new ListNode(1);
                        break;
                    }
                }else{
                    nowNode.next = leftNode;
                    break;
                }
                
            }
            
        }

        return resultHeadPre.next;
    }
}