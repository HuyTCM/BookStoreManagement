<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="HISTORIES" value="${HISTORIES}" />
<div class="container">
	<div class="c-header"></div>
	<div class="card">
		<div class="card-header">
			<h2>
				History <small></small>
			</h2>
		</div>

		<div id="data-table-command-header"
			class="bootgrid-header container-fluid">
			<div class="row">
			
			</div>
		</div>
		<table id="data-table-command"
			class="table table-striped table-vmiddle bootgrid-table"
			aria-busy="false">
			<thead>
				<tr>
					<th data-column-id="id" class="text-left" style=""><a
						href="javascript:void(0);" class="column-header-anchor sortable"><span
							class="text">Book ID</span><span class="zmdi icon "></span></a></th>
					<th data-column-id="sender" class="text-left" style=""><a
						href="javascript:void(0);" class="column-header-anchor sortable"><span
							class="text">Book title</span><span class="zmdi icon "></span></a></th>
					<th data-column-id="received" class="text-left" style=""><a
						href="javascript:void(0);" class="column-header-anchor sortable"><span
							class="text">Borrowed date</span><span
							class="zmdi icon zmdi-expand-more"></span></a></th>
					<th data-column-id="commands" class="text-left" style=""><a
						href="javascript:void(0);" class="column-header-anchor "><span
							class="text">Commands</span><span class="zmdi icon "></span></a></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty  HISTORIES}">
					<c:forEach var="history" items="${HISTORIES}">
						<tr data-row-id="${history.id}">
							<td class="text-left" style="">${history.bookId}</td>
							<td class="text-left" style="">
							<span id="book-name-${history.bookId}"></span>
							<script>
									getBookName('${history.bookId}');
									function getBookName(bookId) {
										$.ajax({
											url : "book-name",
											data : {
												'bookId' : bookId
											},
											success : function(result) {
												$('#book-name-' + bookId).text(result);
											}
										})
									}
								</script>
							</td>
							<td class="text-left" style=""><fmt:formatDate
									value="${history.borrowedDate.time}" type="date"
									pattern="dd/mm/yyyy" /></td>
							<td class="text-left" style=""><button type="button"
									class="btn command-edit waves-effect"
									data-book-id="${history.bookId}"
									<c:if test="${not history.isReturned}">
										data-toggle="modal"
										href="#modalNarrower"
									</c:if>
									style="color : black;">
									<c:if test="${history.isReturned}">
										Returned
									</c:if>
									<c:if test="${not history.isReturned}">
										Borrowing
									</c:if>
								</button>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div id="data-table-command-footer"
			class="bootgrid-footer container-fluid">
			<div class="row">

			</div>
		</div>
	</div>
</div>

<!-- Modal Small -->
<div class="modal fade" id="modalNarrower" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog modal-sm" style="padding-top: 20%;">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Return book</h4>
			</div>
			<form action="return-book" method="get">
				<div class="modal-body">

					<input id="txtBookId" type="hidden" name="txtBookId" />
					<p class="c-black f-500 m-b-20">Date</p>

					<div class="input-group form-group">
						<span class="input-group-addon"><i
							class="zmdi zmdi-calendar"></i></span>
						<div class="dtp-container fg-line">
							<input type='text' name="txtFromDate"
								class="form-control date-picker" placeholder="Click here...">
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-link">Save changes</button>
					<button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script
				src="${pageContext.request.contextPath}/resources/js/borrow-history.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>

