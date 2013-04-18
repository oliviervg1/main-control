<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
  $(function() {
    $("#osmAudio").osmplayer({
      file: '/media/music/test.mp3',
      width: '100%',
      showController: 'true',
      controllerOnly: 'true'
    });
  });
</script>

<script type="text/javascript">
  $(function() {
    $("#osmVideo").osmplayer({
      playlist: '/assets/osmplayer/playlist.xml',
      width: '100%',
      height: '600px'
    });
  });
</script>

<script type="text/javascript">
  $('#mediaTabs a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
  });
</script>

<script type="text/javascript">
	function addVideo() {
		var video = 'media/addTrack?p=' + getTitle() + '&p=' + getUrl() + '&p=' + getType();
		window.location.href = video;
		return false;
	};
	
	function getTitle() {
		return document.getElementById("videoTitle").value;
	};

	function getUrl() {
		return document.getElementById("videoUrl").value; 
	};
	
	function getType() {
		var radios = document.getElementsByName("optionsRadios");
		for (var i = 0; i < radios.length; i++) {       
		    if (radios[i].checked) {
		        return radios[i].value;
		    }
		}   
	};
</script>

<ul id="mediaTabs" class="nav nav-tabs">
	<li class="active"><a href="#audio" data-toggle="tab">Audio</a></li>
    <li><a href="#video" data-toggle="tab">Video</a></li>
</ul>
            
<div id="mediaTabsContent" class="tab-content">
	<div class="tab-pane fade in active" id="audio">
    	<h1 class="lead">Audio Test</h1>
		<div id="osmAudio"></div>
	</div>
   	<div class="tab-pane fade" id="video">
    	<h1 class="lead">Video Test</h1>
		<div id="osmVideo"></div>
		
		<div>
			<!-- Button to trigger modals -->
			<div class="row-fluid btn-centered">
				<div class="span6">	
					<a href="#addVideo" role="button" class="btn btn-large" data-toggle="modal">Add a video to playlist</a>
				</div>
				<div class="span6">
					<a href="#deleteVideo" role="button" class="btn btn-danger btn-large" data-toggle="modal">Remove a video from playlist</a>
				</div>
			</div>
			
			<!-- Add Video -->
			<div id="addVideo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="ModalLabel">Which video are you looking to add?</h3>
			  </div>
			  <div class="modal-body">
			     <form onSubmit="return addVideo()" action="">
				  <fieldset>
				    <legend>Please fill the following:</legend>
				    <label>Video title</label>
				    <input type="text" id="videoTitle" placeholder="Type title here...">
				    <label>Video type</label>
				    <label class="radio inline">
					  <input type="radio" name="optionsRadios" id="optionsRadios1" value="Youtube" checked> Youtube
					</label>
					<label class="radio inline">
					  <input type="radio" name="optionsRadios" id="optionsRadios2" value="Vimeo"> Vimeo
					</label>
					<label class="radio inline">
					  <input type="radio" name="optionsRadios" id="optionsRadios3" value="HTML5"> HTML5
					</label>
				    <label>Video URL</label>
				    <input type="text" id="videoUrl" placeholder="Type URL here...">
				    <span class="help-block">Example: http://www.youtube.com/watch?v=X5_MAxoYwsQ</span>
				    <button type="submit" class="btn">Add video</button>
				  </fieldset>
				</form>
			  </div>
			</div>
			 
			<!-- Delete Video -->
			<div id="deleteVideo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="ModalLabel">Select a video to remove</h3>
			  </div>
			  <div class="modal-body">
			     <table class="table table-hover">
				  <thead>
				    <tr>
				      <th>#</th>
				      <th>Title</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="track" items="${appModels}" varStatus="loop">
				    	<tr>
				    		<td>${loop.index}</td>
							<td><a href="media/removeTrack?p=${track}">${track}</a></td>
						</tr>
					</c:forEach>
				  </tbody>
				</table>
			  </div>
			  <div class="modal-footer">
			    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			  </div>
			</div>
		</div>
	</div>
</div>