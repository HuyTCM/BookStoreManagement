<div class="container">
	<div class="card">
		<div class="card-header">
			<h2>
				List book <small></small>
			</h2>
		</div>
		<table id="data-table-command"
			class="table table-striped table-vmiddle">
			<thead>
				<tr>
					<th data-column-id="id" data-type="numeric">ID</th>
					<th data-column-id="sender">Book title</th>
					<th data-column-id="received" data-order="desc">Published date</th>
					<th data-column-id="status">Status</th>
					<th data-column-id="commands" data-formatter="commands"
						data-sortable="false">Commands</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>10238</td>
					<td>eduardo@pingpong.com</td>
					<td>Available</td>
					<td>14.10.2013</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/vendors/bootgrid/jquery.bootgrid.updated.min.js"></script>
<!-- Data Table -->
<script type="text/javascript">
            $(document).ready(function(){
                //Command Buttons
                $("#data-table-command").bootgrid({
                    css: {
                        icon: 'zmdi icon',
                        iconColumns: 'zmdi-view-module',
                        iconDown: 'zmdi-expand-more',
                        iconRefresh: 'zmdi-refresh',
                        iconUp: 'zmdi-expand-less'
                    },
                    formatters: {
                        "commands": function(column, row) {
                            return "<button type=\"button\" class=\"btn btn-icon command-edit waves-effect waves-circle\" data-row-id=\"" + row.id + "\"><span class=\"zmdi zmdi-edit\"></span></button> " + 
                                "<button type=\"button\" class=\"btn btn-icon command-delete waves-effect waves-circle\" data-row-id=\"" + row.id + "\"><span class=\"zmdi zmdi-delete\"></span></button>";
                        }
                    }
                });
            });
</script>