package main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Member;
import model.Members;

public class Java8_Main {

    private static Members members = new Members();

    static
    {
        members.getMembers().add(new Member("Lokesh", "Gupta", 16));
        members.getMembers().add(new Member("Alex", "Kolenchiskey", 18));
        members.getMembers().add(new Member("David", "Kameron", 15));
        members.getMembers().add(new Member("Lokesh", "Aron", 17));
        members.getMembers().add(new Member("Lokesh", "Aron", 15));
    }

    public static void main(String[] args) {

        System.out.println("Danh sách hội viên ban đầu:");
        members.getMembers().forEach(System.out::println);

        System.out.println("\n******************************\n");
        System.out.println("Danh sách hội viên sau khi group theo first name:");

        Map<String, List<Member>> memberGroups = members.getMembers().stream().collect(Collectors.groupingBy(Member::getFirstName));
        memberGroups.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("\n******************************\n");
        System.out.println("Danh sách hội viên sau sort theo last name và age:");

        memberGroups.entrySet().forEach(entry -> {
            List<Member> membersSorted = entry.getValue().stream()
                                              .sorted(Comparator.comparing(Member::getLastName).thenComparing(Member::getAge))
                                              .collect(Collectors.toList());
            entry.setValue(membersSorted);
        });

//        memberGroups = members.getMembers().stream()
//                                .sorted(Comparator.comparing(Member::getLastName).thenComparing(Member::getAge))
//                                .collect(Collectors.groupingBy(Member::getFirstName));
        memberGroups.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));
    }
}
