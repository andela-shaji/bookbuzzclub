# BookBuzz Club

This is an application that is used to manage the operations of BookBuzz Club. Members are placed into two lists, one for students and another for staff. Their priority depends on:
- The **rank**, i.e if two members are requesting for the same book at the same time, staff will have a higher precedence to a student.
- The **time of entry**, i.e. an older student/staff will have higher precedence to the newer. 

The application implements several classes that define the properties and operations of the Club. 

#### BookBuzzClub Class
This is the main class that manages the interdependence between between the members and the books and the activities it does perform include:
- Add new members and books to the club.
- Add members to the queue when they request for a book.
- Verify if a borrower is a registered member.
- Verify the availability of a book when a borrower requests for it.
- View a list of members and books the club has registered.

#### MemberBookQueue Class
This class places a borrower in the queue when they request for a book and some of the activities it does include:
- Adding a borrower to the queue.
- Removing a borrower from the queue when they have been granted the book.
- Get the size of the queue.
- Check whether the queue is empty.

#### Book Class
It defines the properties of a book such as the name of the author, the book title, the isbn number and the number of copies.

#### Member Class
This class defines the properties and behavior for all the members. It implements the Comparator Interface for sorting the queue.

#### Staff Class
This class defines properties and behaviors that are specific to the staff members and it also extends the Member Class.

#### Student Class
Similar to Staff Class, this class defines properties and behaviors that are specific to the student members and extends the Member Class.

### Contributing

Contributions are welcome and will be fully credited.

We accept contributions via Pull Requests on [Github]: <https://github.com/andela-shaji/bookbuzzclub>.
