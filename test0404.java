/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5

示例 2:
输入: 1->1->1->2->3
输出: 2->3
        */
package lianxi0404;

public class test0404 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head ;
        }
        if(head.next.next == null ){
            if(head.val == head.next.val){
                return null;
            }else{
                return head;
            }
        }

        ListNode node = new ListNode(0);
        if(node.val == head.val){
            node.val = -1;
        }

        node.next = head;
        ListNode cur1 = node;
        ListNode cur2 = node;
        while(cur2.next != null){
            if(cur2.val == cur2.next.val){
                cur2 = cur2.next;
            }else{
                if( cur2.next.next == null || cur2.next.val != cur2.next.next.val ){
                    cur2 = cur2.next;
                    if(cur1.next.val != cur2.val){
                        cur1.next = cur2;
                        cur1 = cur1.next;
                    }else{
                        cur1 = cur1.next;
                    }
                }else{
                    cur2 = cur2.next;
                    //cur1.next = cur2;

                }
            }
        }
        cur1.next = null;
        return node.next;
    }
}
 class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }
