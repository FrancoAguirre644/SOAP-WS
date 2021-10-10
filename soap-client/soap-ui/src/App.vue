<template>
  <div>
    <Navbar />
      <div class="container-fluid">
        <div class="row justify-content-center mt-4">
            <router-view></router-view>
        </div>
      </div>
  </div>
</template>

<script>
import Navbar from "./components/Navbar.vue";

export default {
  name: "App",
  components: {
    Navbar,
  },
};
</script>

