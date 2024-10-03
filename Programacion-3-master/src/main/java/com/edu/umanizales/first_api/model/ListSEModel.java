package com.edu.umanizales.first_api.model;

import lombok.Data;

@Data
public class ListSEModel {
    private Node head;
    private int size;

    public void addKidToFinal(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(kid));
        }
        size++;
    }

    public void addKidToStart(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void addKidInPosition(Kid kid, int position) {
        Node newNode = new Node(kid);
        if (position <= size && position > 0) {

            if (position == 1) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node temp = head;
                int contador = 1;
                while (contador < position - 1) {
                    temp = temp.getNext();

                    contador++;
                    ;
                }
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                size++;
            }
        }
        else {
            addKidToFinal(newNode.getData());
        }

    }

    public void investKids(){
        ListSEModel copyList = new ListSEModel();
        if(size>=2){
            Node temp = head;
            while(temp!=null){
                copyList.addKidToStart(temp.getData());
                temp = temp.getNext();
            }

        }head = copyList.getHead();

    }

    public Node deleteForID(int id) {
        Node temp = head;
        if (head.getData().id == id) {
            head = head.getNext();
            size--;
        }
        else {
        while (temp.getNext() != null) {

                if (temp.getNext().getData().id == id) {
                    Node nodeDelete = temp.getNext();
                    temp.setNext(nodeDelete.getNext());
                    size--;
                    return head;
                }
                temp = temp.getNext();
        }}
 return head;
    }

    public Node deleteForPosition(int position) {
        if (position <= size && position > 0) {
            if (position == 1) {
                head = head.getNext();
                size--;
            } else {
                Node temp = head;
                int contador = 1;
                while (contador < position - 1) {
                    temp = temp.getNext();

                    contador++;
                }
                Node nodeDelete = temp.getNext();
                temp.setNext(nodeDelete.getNext());
                size--;
            }

        }
        return head;
    }
    public void interleaveByGender() {
        if(size>2){
            int tempWomen = 1;
            int tempMen = 2;
            ListSEModel copyListGender = new ListSEModel();
            Node temp = head;
            while (temp != null) {
                if(temp.getData().gender.equalsIgnoreCase("femenino")){
                copyListGender.addKidInPosition(temp.getData(), tempWomen);
                tempWomen+=2;}
                else{
                    copyListGender.addKidInPosition(temp.getData(), tempMen);
                    tempMen+=2;
                    }
                temp = temp.getNext();
            }  head = copyListGender.getHead();
        }
    }
    public Node interleaveHeadAndTail() {

        if(size>=2){

        Node tempHead = head;
        Node tempTail = head;
        int contador = 1;
        while (contador <= 2) {
            tempTail = tempTail.getNext();
            contador++;
        }
       Kid Kidcopy = tempHead.getData();
        tempHead.setData(tempTail.getData());
        tempTail.setData(Kidcopy);

    }
    return head;
    }
}







