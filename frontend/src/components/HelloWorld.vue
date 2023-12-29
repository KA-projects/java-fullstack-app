<script setup lang="ts">
import { onMounted, ref } from 'vue'

defineProps<{ msg: string }>()

const count = ref(0);
const content = ref();

onMounted(() => {
  fetchData();
});

const fetchData = async () => {
  const res = await fetch("http://localhost:8080/greeting?name=Iron",
    {
      // headers: 'Access-Control-Allow-Origin'
    }
  );
  console.log(res);

  const data = await res.json();
  console.log(data);
  content.value = data;

}

</script>

<template>
  <h1>{{ msg }}</h1>

  <div>Answer is {{ content.content }} </div>

  <div class="card">
    <button type="button" @click="count++">count is {{ count }}</button>
    <p>
      Edit
      <code>components/HelloWorld.vue</code> to test HMR
    </p>
  </div>

  <p>
    Check out
    <a href="https://vuejs.org/guide/quick-start.html#local" target="_blank">create-vue</a>, the official Vue + Vite
    starter
  </p>
  <p>
    Install
    <a href="https://github.com/vuejs/language-tools" target="_blank">Volar</a>
    in your IDE for a better DX
  </p>
  <p class="read-the-docs">Click on the Vite and Vue logos to learn more</p>
</template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
