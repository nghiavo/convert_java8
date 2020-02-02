package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Member;
import model.Members;

public class Java6_Main {

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
        for (Member member : members.getMembers()) {
            System.out.println(member);
        }

        System.out.println("\n******************************\n");
        System.out.println("Danh sách hội viên sau khi group theo first name:");

        Map<String, List<Member>> memberGroups = new HashMap<>();
        for (int i = 0; i < members.getMembers().size(); i++) {
            Member member = members.getMembers().get(i);
            if (memberGroups.containsKey(member.getFirstName())) {
                continue;
            }

            String key = member.getFirstName();
            List<Member> membersGrouped = new ArrayList<>();
            for (int j = i; j < members.getMembers().size(); j++) {
                if (members.getMembers().get(j).getFirstName().equals(key)) {
                    membersGrouped.add(members.getMembers().get(j));
                }
            }

            memberGroups.put(key, membersGrouped);
        }

        for (Map.Entry<String, List<Member>> entry : memberGroups.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        System.out.println("\n******************************\n");
        System.out.println("Danh sách hội viên sau sort theo last name và age:");

        for (Map.Entry<String, List<Member>> entry : memberGroups.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                for (int j = i + 1; j < entry.getValue().size(); j++) {

                    Member member1 = entry.getValue().get(i);
                    Member member2 = entry.getValue().get(j);

                    if (member1.getLastName().compareTo(member2.getLastName()) > 0) {
                        entry.getValue().set(i, member2);
                        entry.getValue().set(j, member1);
                    }

                    if (member1.getLastName().compareTo(member2.getLastName()) == 0) {
                        if (member1.getAge() > member2.getAge()) {
                            entry.getValue().set(i, member2);
                            entry.getValue().set(j, member1);
                        }
                    }
                }
            }
        }

        for (Map.Entry<String, List<Member>> entry : memberGroups.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
