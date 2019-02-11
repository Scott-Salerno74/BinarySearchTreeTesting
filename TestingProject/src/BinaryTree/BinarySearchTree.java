package BinaryTree;

import Models.PersonRecord;

public class BinarySearchTree {


    Node root;

    // store people by last name

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if(node == null) {
            return 0;
        } else {
            return(size(node.left) + 1 + size(node.right));
        }
    }

    // We want to keep the tree sorted


    // If the new node's value is lower than the current node, go to the left child
    // If the new node's value is greater than the current node, go to the right child
    // When the current node is null, we've reached a leaf node and can insert the new node in that position

    public void add(PersonRecord value) {
        root = add(root, value);
        //System.out.println(this.root.value.toString());
    }


    private Node add(Node current, PersonRecord person) {

        if(current == null) {
            //System.out.println("Add");
            //System.out.println(person.toString());
            return new Node(person);
        }

        int comparison = person.getLastName().compareTo(current.value.getLastName());

        if(comparison < 0) {
            current.left = add(current.left, person);
        } else if(comparison > 0) {
            current.right = add(current.right, person);
        } else {
            current.value = person;
        }
        return current;


        /*
        if(current == null) {
            current = new Node(person);
            return current;
        }

        if(person.getLastname().compareTo(current.value.getLastname()) < 0)  {

            if(current.left == null) {
                // add a child as n.left
                current.left = new Node(person);

            } else {
                current.left = add(current.left, person);
            }
        } else if(person.getLastname().compareTo(current.value.getLastname()) > 0) {

            if(current.right == null) {
                current.right = new Node(person);
            } else {
                current.right = add(current.right, person);
            }
        }
        return current;
*/
    }


    public PersonRecord getPersonRecordByLastName(String n) {
        Node node = getPersonNodeByLastName(root, n);

        if(node == null) {
            System.out.println("THE PERSON IS NULL");
        }

        String id = node.value.getId();
        String firstName = node.value.getFirstName();
        String lastName = node.value.getLastName();
        String email = node.value.getEmail();
        String company = node.value.getCompany();
        String jobTitle= node.value.getJobTitle();
        String university = node.value.getUniversity();


        PersonRecord personToReturn = new PersonRecord(id, firstName, lastName, email, company, jobTitle, university);

        return personToReturn;
    }

    private Node getPersonNodeByLastName(Node root, String lastName) {

        if(root == null) {
            System.out.println("in if");
            return null;
        }

        int comparison = lastName.compareTo(root.value.getLastName());
        if(comparison < 0) {
            return getPersonNodeByLastName(root.left, lastName);
        } else if(comparison > 0) {
            return getPersonNodeByLastName(root.right, lastName);
        } else {
            return root;
        }
    }

// get all nodes

    public boolean contains(String lastName) {
        return contains(root, lastName);
    }

    private boolean contains(Node current, String lastName) {

        if(current == null)
            return false;

        int comparison = lastName.compareTo(root.value.getLastName());

        if(comparison < 0) {
            return contains(current.left, lastName);
        } else if(comparison > 0) {
            return contains(current.right, lastName);
        } else {
            return true;
        }

    }

}
