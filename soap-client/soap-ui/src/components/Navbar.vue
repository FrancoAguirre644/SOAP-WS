<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid">
      <router-link class="navbar-brand" :to="{ name: 'country-index' }">
        <img src="https://es.vuejs.org/images/logo.png" width="35" alt="" />
      </router-link>
    </div>
  </nav>
</template>

<script>
export default {
  setup() {
    return {};
  },
};
</script>
