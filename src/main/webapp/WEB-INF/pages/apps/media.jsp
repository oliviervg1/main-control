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
  })
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
	</div>
</div>