package BinaryTree;

import Models.PersonRecord;

public class BinarySearchTree {


    Node root;

    public int total;
    // store people by last name

    public BinarySearchTree() {
        root = null;
        this.total = 0;
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
        add(root, value);
    }


    private Node add(Node current, PersonRecord person) {

        if(current == null) {
            this.total++;
            System.out.println("Setting node");
            this.root = new Node(person);
            //System.out.println(this.root.value.getLastname());
            return this.root;
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
    }

    public PersonRecord getPersonRecordByLastName(String n) {
        Node node = getPersonNodeByLastName(root, n);

        String id = node.value.getId();
        String firstName = node.value.getFirstName();
        String lastName = node.value.getLastname();
        String email = node.value.getEmail();
        String company = node.value.getCompany();
        String jobTitle= node.value.getJobTitle();
        String university = node.value.getUniversity();


        PersonRecord personToReturn = new PersonRecord(id, firstName, lastName, email, company, jobTitle, university);

        return personToReturn;
    }

    private Node getPersonNodeByLastName(Node root, String lastName) {
        if(root == null) {
            return root;
        }

        if(root.value.getLastname().equals(lastName)) {
            return root;
        }

        if(root.value.getLastname().compareTo(lastName) < 0) { // val is greater than the root's last name value
            return getPersonNodeByLastName(root.right, lastName);
        } else { // less than the roots value
            return getPersonNodeByLastName(root.right, lastName);
        }
    }

// get all nodes

    public boolean contains(PersonRecord value) {
        return contains(root, value);
    }

    private boolean contains(Node current, PersonRecord personToFind) {
        if(current == null) {
            return false;
        }

        if(personToFind.getLastname().equals(current.value.getLastname())) {
            return true;
        }

        if(personToFind.getLastname().compareTo(current.value.getLastname()) < 0) { // current nodes value is less than the key we are looking for
            contains(current.left, personToFind);
        } else {
            contains(current.right, personToFind);
        }

        return false;
    }

}
