import {Article} from "./article/article";

export class Page<T> {
  total: number;
  data: T[];
  pageNum:number;
  pageSize:number;
}
