package org.primefaces.test;

import org.primefaces.event.DragDropEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "testView")
@ViewScoped
public class TestView implements Serializable {

    private List<String> availableStrings = new ArrayList<>();

    @PostConstruct
    public void init() {
        availableStrings.add("A-tbl1");
        availableStrings.add("B-tbl1");
        availableStrings.add("C-tbl1");
        availableStrings.add("D-tbl1");
        availableStrings.add("E-tbl2");
        availableStrings.add("F-tbl2");
        availableStrings.add("G-tbl2");
        availableStrings.add("H-tbl3");
        availableStrings.add("I-tbl3");
        availableStrings.add("J-tbl3");
        availableStrings.add("K-tbl3");
        availableStrings.add("L-tbl3");
        availableStrings.add("M-tbl3");


    }

    public List<String> getTbl1Strings(){
        return availableStrings.stream()
                .filter(s -> s.endsWith("tbl1"))
                .collect(Collectors.toList());
    }

    public List<String> getTbl2Strings(){
        return availableStrings.stream()
                .filter(s -> s.endsWith("tbl2"))
                .collect(Collectors.toList());
    }

    public List<String> getTbl3Strings(){
        return availableStrings.stream()
                .filter(s -> s.endsWith("tbl3"))
                .collect(Collectors.toList());
    }

    public List<String> getAvailableStrings() {
        return availableStrings;
    }

    public void onTbl1Drop(DragDropEvent event){
        String stringToMove = (String) event.getData();
        String stringEndingWithTbl1 = changeStringEnding(stringToMove, "tbl1");
        availableStrings.remove(stringToMove);
        availableStrings.add(stringEndingWithTbl1);
    }

    public void onTbl2Drop(DragDropEvent event){
        String stringToMove = (String) event.getData();
        String stringEndingWithTbl2 = changeStringEnding(stringToMove, "tbl2");
        availableStrings.remove(stringToMove);
        availableStrings.add(stringEndingWithTbl2);
    }

    public void onTbl3Drop(DragDropEvent event){
        String stringToMove = (String) event.getData();
        String stringEndingWithTbl3 = changeStringEnding(stringToMove, "tbl3");
        availableStrings.remove(stringToMove);
        availableStrings.add(stringEndingWithTbl3);
    }

    private String changeStringEnding(String initString, String newEnding) {
        return initString.substring(0,2) + newEnding;
    }
}
