<template>
    <div id="container">
        <header>
            <nav>
                <RouterLink to="/">Home</RouterLink> |
                <RouterLink to="/video">Video</RouterLink>
            </nav>
        </header>
    </div>
</template>

<script setup>

</script>

<style scoped>
#container {
    align-items: center;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background-color: #000000;
    font-size: 25px;
    height: 50px
}

nav a {
    font-weight: bold;
    text-decoration: none;
    color: rgb(255, 255, 255);
}

nav a.router-link-exact-active {
    color: #42b983
}
</style>