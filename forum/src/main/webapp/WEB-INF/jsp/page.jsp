<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport content="width=device-width, initial-scale="1.0">
    <link rel="stylesheet" href="styles.css">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="index.js" defer></script>
    <title>Fun with JS!</title>
</head>
<body>
<h2>My Playlists</h2>
<ul id="playlists">
</ul>
<h2>Create a Playlist</h2>
<p><%= "This is a hello world!" %></p>
<form class="card-content" id="create-playlist-form">
    <label>Playlist Name
        <input type="text" required class="validated-field" id="playlist-name" placeholder="smooth-jamz" autofocus>
    </label>
    <label>Tags
        <input type="text" id="tags" class="tags" placeholder="tag1,tag2" data-tip="Must be a comma separated list of tags.">
    </label>
    <input type="submit" id="create" value="Create">
</form>
</body>
</html>
