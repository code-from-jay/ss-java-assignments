# Assignment 1
SELECT (CASE WHEN COUNT(*) > 0 THEN noOfCopies ELSE 0 END) as noOfCopies
FROM tbl_book_copies
WHERE bookId = (SELECT bookId FROM tbl_book WHERE title = "The Lost Tribe")
AND branchId = (SELECT branchId FROM tbl_library_branch WHERE branchName = 'Sharpstown');

# Assignment 2
SELECT tbl_library_branch.branchName as Branch, tbl_book.title as Book, tbl_book_copies.noOfCopies as Copies
FROM tbl_book_copies
INNER JOIN tbl_book ON tbl_book_copies.bookId=tbl_book.bookId
INNER JOIN tbl_library_branch ON tbl_book_copies.branchId=tbl_library_branch.branchId
WHERE tbl_book_copies.bookId = (SELECT tbl_book.bookId FROM tbl_book WHERE title = "The Lost Tribe");

# Assignment 3
SELECT name FROM tbl_borrower
LEFT OUTER JOIN tbl_book_loans
ON tbl_borrower.cardNo=tbl_book_loans.cardNo
WHERE tbl_book_loans.cardNo IS NULL;

# Assignment 4
SELECT book.title as Title, borrower.name as Name, borrower.address as Address
FROM tbl_book_loans
INNER JOIN tbl_book AS book ON book.bookId=tbl_book_loans.bookId
INNER JOIN tbl_borrower AS borrower ON borrower.cardNo=tbl_book_loans.cardNo
WHERE branchId = (SELECT branchId FROM tbl_library_branch WHERE branchName = 'Sharpstown')
AND CAST(dueDate as DATE) = current_date();

# Assignment 5
SELECT branch.branchName as Branch, COUNT(loans.cardNo) as Loans
FROM tbl_library_branch AS branch
LEFT JOIN tbl_book_loans AS loans USING (branchId)
GROUP BY branch.branchName;

# Assignment 6
SELECT borrower.name as Name, borrower.address as Address, COUNT(loans.bookId) as Loans
FROM tbl_borrower AS borrower
LEFT JOIN tbl_book_loans AS loans USING (cardNo)
GROUP BY borrower.name
HAVING Loans > 5;

# Assignment 7
SELECT book.title AS Title, IFNULL(copies.noOfCopies, 0) AS "Copies in Central"
FROM tbl_book AS book
LEFT JOIN tbl_author AS author
	ON author.authorId = book.authId
LEFT JOIN tbl_book_copies AS copies
	ON
		copies.branchId = (
			SELECT branchId
			FROM tbl_library_branch
			WHERE branchName = 'Central')
		AND copies.bookId = book.bookId
WHERE book.authId = (SELECT authorId FROM tbl_author WHERE authorName LIKE '%Stephen King%')
GROUP BY book.bookId;