<div>
	<h1>Audio Test</h1>
	<audio controls>
  		<source src="/media/music/test.mp3" type="audio/mpeg">
		Your browser does not support the audio element.
	</audio>
</div>

<script type="text/javascript">
  $(function() {
    $("#osmplayer").osmplayer({
      playlist: 'playlist.xml',
      height: '500px'
    });
  });
</script>

<div>
	<h1>Video Test</h1>
	<div id="osmplayer"></div>
</div>