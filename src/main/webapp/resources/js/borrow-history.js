/**
 * 
 */
(function() {
	$('#modalNarrower').on('show.bs.modal', function(e) {
		var book = e.relatedTarget.dataset.bookId;
		$('#txtBookId').val(book);
	});
}).call();
