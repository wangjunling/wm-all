import {Component,OnInit} from "@angular/core"

import {ArticleService} from "./article.service";
import {Article} from "./article";
import {Page} from "../Page";
@Component({
  selector:'article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit{

  page:Page<Article> = null;
  articles:Article[] = [];
  constructor(private articleService:ArticleService) {
  }

  ngOnInit(): void {
    this.articleService.getArticlePage().then(value =>this.page = value).then(value => this.articles=value.data)
  }

}
