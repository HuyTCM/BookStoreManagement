/**
 * 
 */
(function() {
	$('#modalDefault').on('show.bs.modal', function(e) {
		var book = e.relatedTarget.dataset.bookId;
		var bookTilte = e.relatedTarget.dataset.bookTitle;
		$('.modal-title').text(bookTilte);
		$('#book-description').text(e.relatedTarget.dataset.bookDescription);
		$('#book-published-date').text(e.relatedTarget.dataset.bookPublishedDate);
		$('#num-of-borrowed').text(e.relatedTarget.dataset.bookNumOfBorrowed);
		$('#book-authors').text(e.relatedTarget.dataset.bookAuthors);
		$('#book-categories').text(e.relatedTarget.dataset.bookCategories);
		
		$('#btn-modal-save').attr('data-book-id', book);
		// Do some stuff w/ it.
	});
	
	$('#modalNarrower').on('show.bs.modal', function(e) {
		var book = e.relatedTarget.dataset.bookId;
		$('#txtBookId').val(book);
	});
}).call();