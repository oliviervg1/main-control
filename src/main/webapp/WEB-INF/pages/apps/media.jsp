<div>
	<h1 class="lead">Audio Test</h1>
	<audio controls>
  		<source src="/media/music/test.mp3" type="audio/mpeg">
		Your browser does not support the audio element.
	</audio>
</div>

<script type="text/javascript">
  $(function() {
    $("#osmplayer").osmplayer({
      playlist: '/assets/osmplayer/playlist.xml',
      width: '100%',
      height: '600px'
    });
  });
</script>

<div>
	<h1 class="lead">Video Test</h1>
	<div id="osmplayer"></div>
</div>