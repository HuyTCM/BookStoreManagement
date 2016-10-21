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
							<input type="text" class="form-control" placeholder="Title">
						</div>
					</div>
					<br />
					<div class="form-group">
						<label>Author</label>
						<div class="fg-line">
							<select class="selectpicker" multiple>
								<option>Mustard</option>
								<option>Ketchup</option>
								<option>Relish</option>
								<option>Toasted</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label>Genres of Books</label>
						<div class="fg-line">
							<select class="chosen" multiple
								data-placeholder="Choose a Genre...">
								<option value="United States">United States</option>
								<option value="United Kingdom">United Kingdom</option>
								<option value="Afghanistan">Afghanistan</option>
								<option value="Aland Islands">Aland Islands</option>
								<option value="Albania">Albania</option>
								<option value="Algeria">Algeria</option>
								<option value="American Samoa">American Samoa</option>
							</select>
						</div>
					</div>
					<div>
						<label>Published date</label>
						<div class="input-group form-group">
							<span class="input-group-addon"><i
								class="zmdi zmdi-calendar"></i></span>
							<div class="dtp-container fg-line">
								<input type="text" class="form-control date-picker"
									placeholder="Click here...">
							</div>
						</div>
					</div>
					<div>
						<label>Description</label>
						<div class="form-group">
							<div class="fg-line">
								<textarea class="form-control" rows="5"
									placeholder="Say something about this book..."></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
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