<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="AUTHORS" value="${AUTHORS}" />
<c:set var="CATEGORIES" value="${CATEGORIES}" />

<link
	href="${pageContext.request.contextPath}/resources/vendors/bower_components/bootstrap-select/dist/css/bootstrap-select.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/bower_components/chosen/chosen.min.css"
	rel="stylesheet">
<div class="container">
	<div class="c-header">
	</div>
	<div class="card">
		<div class="card-header">
			<h2>
				Add new book <small>Add new book information to store for
					available to search and borrow.</small>
			</h2>
		</div>
		<div class="card-body card-padding">
		<form action="addBook" method="POST">
			<div class="row">
				<div class="col-sm-4">
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-preview thumbnail" data-trigger="fileinput"></div>
						<div>
							<span class="btn btn-info btn-file waves-effect"> <span
								class="fileinput-new">Select image</span> <span
								class="fileinput-exists">Change</span> <input type="file"
								name="...">
							</span> <a href="#" class="btn btn-danger fileinput-exists waves-effect"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<span class="input-group-addon"><i class="zmdi zmdi-book"></i></span>
						<div class="fg-line">
							<input type="text" name="txtTitle" class="form-control" placeholder="Title">
						</div>
					</div>
					<br />
					<div class="form-group">
						<label>Author</label>
						<div class="fg-line">
							<select name="slAuthor" class="selectpicker" multiple>
								<c:if test="${not empty AUTHORS}">
									<c:forEach var="author" items="${AUTHORS}">
										<option value="${author.id}">${author.name}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label>Genres of Books</label>
						<div class="fg-line">
							<select name="slGenre" class="chosen" multiple
								data-placeholder="Choose a Genre...">
								<c:if test="${not empty CATEGORIES}">
									<c:forEach var="category" items="${CATEGORIES}">
										<option value="${category.id}">${category.name}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<div>
						<label>Published date</label>
						<div class="input-group form-group">
							<span class="input-group-addon"><i
								class="zmdi zmdi-calendar"></i></span>
							<div class="dtp-container fg-line">
								<input name="txtPublishedDate" type="text" class="form-control date-picker"
									placeholder="Click here...">
							</div>
						</div>
					</div>
					<div>
						<label>Description</label>
						<div class="form-group">
							<div class="fg-line">
								<textarea name="txtDescription" class="form-control" rows="5"
									placeholder="Say something about this book..."></textarea>
							</div>
						</div>
					</div>
					<div class="row" style="padding-left: 30%;">
					<div class="col-sm-2">
						<button type="reset" class="btn palette-Grey bg waves-effect">Reset</button>
					</div>
					<div class="col-sm-2">
						<button type="submit" class="btn palette-Cyan bg waves-effect">Add</button>
					</div>
				</div>
				</div>
			</div>
			</form>
		</div>
	</div>
</div>
<script
	src="${pageContext.request.contextPath}/resources/vendors/fileinput/fileinput.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/chosen/chosen.jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/bootstrap-select/dist/js/bootstrap-select.js"></script>