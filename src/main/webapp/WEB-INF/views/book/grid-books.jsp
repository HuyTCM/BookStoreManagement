<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="BOOKS" value="${BOOKS}" />
<div class="container">
	<div class="c-header">
		<h2>Contacts</h2>
	</div>
	<div class="card">
		<div class="action-header palette-Teal-400 bg clearfix">
			<div class="ah-label hidden-xs palette-White text">Some text
				here</div>
		</div>

		<div class="card-body card-padding">
			<div class="contacts clearfix row">
				<c:if test="${not empty BOOKS}">
					<c:forEach var="book" items="${BOOKS}">
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="c-item">
								<a href="#" class="ci-avatar"> <img src="img/contacts/1.jpg"
									alt="">
								</a>

								<div class="c-info">
									<strong>${book.name}</strong> <small>${book.description}</small>
									<c:set var="authorNames" value="" />
									<c:forEach var="author" items="${book.authors}">
										<c:set var="authorNames"
											value="${authorNames}, ${author.name}" />
									</c:forEach>
									<c:set var="categoryNames" value="" />
									<c:forEach var="category" items="${book.bookCategories}">
										<c:set var="categoryNames"
											value="${categoryNames}, ${category.name}" />
									</c:forEach>
								</div>

								<div class="c-footer">
									<a data-toggle="modal" data-book-id="${book.id}"
										data-book-title="${book.name}"
										data-book-description="${book.description}"
										data-book-authors="<c:out value="${authorNames}"/>"
										data-book-categories="${categoryNames}"
										data-book-published-date=<fmt:formatDate type="both" dateStyle="full" value="${book.publishedDate.time}" pattern="dd/mm/yyyy"/>
										data-book-num-of-borrowed="${book.numOfBorrowed}"
										href="#modalDefault" style="width: 100%;"
										class="btn btn-sm btn-default waves-effect"> Detail </a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>

			<div class="load-more">
				<a href="#"><i class="zmdi zmdi-refresh-alt"></i> Load More...</a>
			</div>
		</div>
	</div>
</div>
<!-- Modal Default -->
<div class="modal fade" id="modalDefault" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Modal title</h4>
			</div>
			<div class="modal-body">
				<div class="card" id="profile-main">
					<div class="pm-overview c-overflow">
						<div class="pmo-pic" style="margin-bottom: 0; margin-top: 0;">
							<div class="p-relative">
								<a href="#"> <img class="img-responsive"
									src="img/profile-pics/profile-pic-2.jpg" alt="">
								</a>

								<div class="dropdown pmop-message">
									<a data-toggle="dropdown" href="#"
										class="btn palette-White bg btn-float z-depth-1"> <i
										class="zmdi zmdi-comment-text-alt"></i>
									</a>
								</div>
							</div>
							<div class="pmo-stat">
								<h2 class="m-0 c-white" id="num-of-borrowed">1562</h2>
								Number of borrow times
							</div>
						</div>

						<div class="pmo-block pmo-contact hidden-xs"
							style="padding-top: 10px;">
							<h2>Description</h2>
							<ul>
								<li><i class="zmdi zmdi-calendar-alt"></i> <span
									id="book-published-date"></span></li>
								<li><i class="zmdi zmdi-email"></i> <span id="book-authors"></span></li>
								<li><i class="zmdi zmdi-facebook-box"></i> <span
									id="book-categories"></span></li>
							</ul>
						</div>
					</div>
					<div class="pm-body clearfix">
						<ul class="tab-nav tn-justified">
							<li class="active waves-effect"><a href="#">About</a></li>
						</ul>
						<div class="pmb-block">
							<div class="pmbb-header">
								<h2>
									<i class="zmdi zmdi-equalizer m-r-5"></i> Summary
								</h2>
							</div>
							<div class="pmbb-body p-l-30">
								<div class="pmbb-view" id="book-description"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="btn-modal-save" type="button" class="btn btn-link"
					data-toggle="modal" data-target="#modalNarrower"
					data-dismiss="modal">Save changes</button>
				<button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
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
				<h4 class="modal-title">Modal title</h4>
			</div>
			<div class="modal-body">
				<form action="" method="get">
					<input id="txtBookId" type="hidden" name="txtBookId" />
					<p class="c-black f-500 m-b-20">From date</p>

					<div class="input-group form-group">
						<span class="input-group-addon"><i
							class="zmdi zmdi-calendar"></i></span>
						<div class="dtp-container fg-line">
							<input type='text' name="txtFromDate"
								class="form-control date-picker" placeholder="Click here...">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-link">Save changes</button>
				<button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/grid-book.js"></script>
